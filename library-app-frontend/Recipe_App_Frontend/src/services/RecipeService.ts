import axios, { AxiosResponse } from 'axios';

const REST_API_BASE_URL = 'http://localhost:8080/api/recipes';

// Define the type for a Recipe
interface Recipe {
  id: number;
  name: string;
  description: string;
  image: string;
}

// Function to fetch recipes, with proper typing for the response
export const listRecipes = (): Promise<AxiosResponse<Recipe[]>> => {
  return axios.get<Recipe[]>(REST_API_BASE_URL);
};
