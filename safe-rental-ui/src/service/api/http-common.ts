import axios, { AxiosResponse } from 'axios';
import { toast } from 'react-hot-toast';
import { getUserToken } from '../auth.service';

interface Params {
  baseUrl: string;
  headers?: { [key: string]: string };
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

const getCommonConfig = (requiresAuth: boolean, token?: string): Params => {
  const headers = {
    'Content-type': 'application/json',
    ...(requiresAuth && token && { Authorization: token }),
  };

  return {
    baseUrl: 'http://localhost:8080',
    headers,
  };
};

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
    console.log(error);
    const response = error.response;

    console.log(
      'status: ' +
        response?.status +
        ' error body: ' +
        JSON.stringify(response?.data)
    );
    if (response?.status > 500) {
      toast.error("Сервис не доступен.")
    }
    toast.error(error.response.data.errMessage);
    throw error;
  }
};

export const getAPI = async <T>(
  url: string,
  requiresAuth = false
): Promise<ApiResponse<T>> => {
  const authToken = getUserToken();

  if (requiresAuth && !authToken) {
    toast.error('Требуется авторизация, чтобы получить доступ к странице');
    return {
      status: 401, // Unauthorized
      errMessage: 'Please log in to access this resource.',
    };
  }

  const config: Params = getCommonConfig(requiresAuth, authToken || undefined);

  return await axios
    .get<T>(`${config.baseUrl}/${url}`, config)

    .then((response) => {
      return {
        status: response.status,
        data: response.data,
      };
    })
    .catch((error) => {
      console.log(error);
      const response = error.response;

      console.log(
        'status: ' +
          response?.status +
          ' error body: ' +
          JSON.stringify(response?.data)
      );
      // alert(error)
      return {
        status: error.status || 500,
        errMessage: response?.data,
      };
    });
};
