import axios, { AxiosResponse } from 'axios';

const REST_API_BASE_URL = 'http://localhost:8080/api/ingredients';

// Define the type for an Ingredient
interface Ingredient {
  id: number;
  name: string;
  quantity: string;
  recipeId: number;
}

// Function to fetch ingredients, with proper typing for the response
export const listIngredients = (): Promise<AxiosResponse<Ingredient[]>> => {
  return axios.get<Ingredient[]>(REST_API_BASE_URL);
};
