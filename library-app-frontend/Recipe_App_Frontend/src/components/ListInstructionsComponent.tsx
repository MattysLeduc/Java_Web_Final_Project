import React, { useEffect, useState } from 'react';
import { listInstructions } from '../services/InstructionService'; // Import service to fetch instructions

// Define the Instruction interface
interface Instruction {
  id: number;
  recipeId: number;
  stepNumber: number;
  instructionText: string;
}

const ListInstructionsComponent: React.FC = () => {
  const [instructions, setInstructions] = useState<Record<number, Instruction[]>>({});

  useEffect(() => {
    listInstructions()
      .then((response) => {
        // Grouping instructions by recipeId
        const groupedInstructions = response.data.reduce(
          (acc: Record<number, Instruction[]>, instruction: Instruction) => {
            if (!acc[instruction.recipeId]) {
              acc[instruction.recipeId] = [];
            }
            acc[instruction.recipeId].push(instruction);
            return acc;
          },
          {}
        );

        setInstructions(groupedInstructions);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  return (
    <div className="container">
      <h2 className="text-center">List of Instructions</h2>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Instruction ID</th>
            <th>Step Number</th>
            <th>Instruction Text</th>
            <th>Recipe ID</th>
          </tr>
        </thead>
        <tbody>
          {Object.keys(instructions).map((recipeId) => (
            <React.Fragment key={recipeId}>
              <tr>
                <td
                  colSpan={4}
                  style={{ backgroundColor: '#f2f2f2', fontWeight: 'bold' }}
                >
                  Recipe ID: {recipeId}
                </td>
              </tr>
              {instructions[parseInt(recipeId)]
                .sort((a, b) => a.stepNumber - b.stepNumber) // Sorting by step number
                .map((instruction) => (
                  <tr key={instruction.id}>
                    <td>{instruction.id}</td>
                    <td>{instruction.stepNumber}</td>
                    <td>{instruction.instructionText}</td>
                    <td>{instruction.recipeId}</td>
                  </tr>
                ))}
            </React.Fragment>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListInstructionsComponent;
