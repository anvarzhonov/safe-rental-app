import axios, { AxiosError } from 'axios'

interface Params {
	baseUrl: string
	headers: any
}

const commonConfig: Params = {
	baseUrl: 'http://localhost:8080',
	headers: { 'Content-type': 'application/json' },
}

interface ApiResponse<T> {
  status: number;
  data: T;
}

export const postAPI = async <T>(url: string, data: any): Promise<ApiResponse<T>> => {
	return await axios
		.post<T>(`${commonConfig.baseUrl}/${url}`, data, commonConfig)
		.then(response => {
			console.log(response)
			return {
				status: response.status,
				data: response.data,
			}
		})
		.catch(error => {
			console.log(error)
			return {
				status: error.response?.status || 500,
				data: error.response,
			}
		});
}

export const getAPI = async <T>(url: string, data?: any): Promise<ApiResponse<T>> => {
	return await axios
		.get<T>(`${commonConfig.baseUrl}/${url}`, commonConfig)

		.then(response => {
			console.log(response)
			return {
				status: response.status,
				data: response.data,
			}
		})
		.catch(error => {
			console.log(error)
			return {
				status: error.status || 500,
				data: error.response,
			}
		})
}

