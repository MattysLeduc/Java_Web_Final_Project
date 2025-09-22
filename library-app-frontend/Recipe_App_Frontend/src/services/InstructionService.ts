import axios, { AxiosResponse } from 'axios';

const REST_API_BASE_URL = 'http://localhost:8080/api/instructions';

// Define the type for an Instruction
interface Instruction {
  id: number;
  stepNumber: number;
  instructionText: string;
  recipeId: number;
}

// Function to fetch instructions, with proper typing for the response
export const listInstructions = (): Promise<AxiosResponse<Instruction[]>> => {
  return axios.get<Instruction[]>(REST_API_BASE_URL);
};
