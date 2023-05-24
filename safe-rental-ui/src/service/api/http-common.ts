import axios, { AxiosResponse } from 'axios';
import { toast } from 'react-hot-toast';

interface Params {
  baseUrl: string;
  headers: any;
}

const commonConfig: Params = {
  baseUrl: 'http://localhost:8080',
  headers: {
    'Content-type': 'application/json',
    Authorization: '',
  },
};

interface ApiResponse<T> {
  status?: number;
  data?: T;
  errMessage?: string;
}

export const postAPI = async <T>(url: string, data: any): Promise<T> => {
  //   return await axios
  //     .post<T>(`${commonConfig.baseUrl}/${url}`, data, commonConfig)
  //     .then((response) => {
  //       return {
  //         status: response.status,
  //         data: response.data,
  //       };
  //     })
  //     .catch((error) => {
  //       toast.error(error.response.data.BaseApiResponse.errMessage);
  // 	  console.log(error.response.data.BaseApiResponse.errMessage);
  //       return {
  //         status: error.response?.status || 500,
  //         errMessage: error.response.data.BaseApiResponse.errMessage,
  //       };
  //     });
  try {
    const response: AxiosResponse<T> = await axios.post<T>(
      `${commonConfig.baseUrl}/${url}`,
      data,
      commonConfig
    );
	console.log(response);
    return response.data;
  } catch (error: any) {
    toast.error(error.response.data.errMessage);
    console.error(error);
    throw error;
  }
};

export const getAPI = async <T>(
  url: string,
  data?: any
): Promise<ApiResponse<T>> => {
  return await axios
    .get<T>(`${commonConfig.baseUrl}/${url}`, commonConfig)

    .then((response) => {
    //   console.log(response);
      return {
        status: response.status,
        data: response.data,
      };
    })
    .catch((error) => {
      console.log(error);
      // alert(error)
      return {
        status: error.status || 500,
        data: error.response,
      };
    });
};
