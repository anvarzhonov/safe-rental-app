import jwtDecode from 'jwt-decode';
import { postAPI } from './api/http-common';

export type RegisterProps = {
  username: string;
  password: string;
};

export type JwtResponse = {
  jwtToken: string;
};

export async function registerNewUser(registerProps: RegisterProps) {
  return await postAPI<String>('auth/signup', registerProps);
}

export async function logIn(authProps: RegisterProps) {
  return await postAPI<JwtResponse>('auth/signin', authProps)
    .then((data) => data.jwtToken)
    .then((jwtToken) => {
      setCurrentUserToken(jwtToken);
      return getCurrentUser();
    })
}

export const setCurrentUserToken = (currentUserToken: string | null) => {
  if (currentUserToken) {
    localStorage.setItem('access-token', currentUserToken);
  } else {
    localStorage.removeItem('access-token');
  }
};

export const signOut = () =>
  new Promise<void>((resolve) => {
    setCurrentUserToken(null);
    resolve();
  });

export const getCurrentUser = (): string | null => {
  const currentUserToken = localStorage.getItem('access-token');
  if (currentUserToken) {
    const decodedJwt = jwtDecode<any>(currentUserToken);
    if (Date.now() >= decodedJwt.exp * 1000) {
      setCurrentUserToken(null);
      return null;
    }
    console.log('CURRENT USER decoded JWT: ' + decodedJwt.sub);
    return decodedJwt.sub;
  }
  return null;
};
