import { getCurrentUser } from '@/service/auth.service';
import React, { ReactNode, useEffect, useState } from 'react';

type Props = {};

interface CurrentUserContextProps {
  currentUser: string | null;
  setCurrentUser: (currentUser: string) => void;
  //   setCurrentUser: React.Dispatch<React.SetStateAction<string | null>>;
}

const CurrentUserContext = React.createContext<CurrentUserContextProps | null>({
  currentUser: '',
  setCurrentUser: () => {},
});

export const CurrentUserContextProvider: React.FC<{ children: ReactNode }> = ({
  children,
}) => {
  const [currentUser, setCurrentUser] = useState<string | null>(null);

  useEffect(() => {
    setCurrentUser(getCurrentUser());
  }, []);

  return (
    <CurrentUserContext.Provider value={{ currentUser, setCurrentUser }}>
      {children}
    </CurrentUserContext.Provider>
  );
};

export default CurrentUserContext;
