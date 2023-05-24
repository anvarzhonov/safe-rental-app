import { Office, OfficeWithoutSafes } from '@/types/map-search.type';
import { ReactNode, createContext, useState } from 'react';

interface SafeRentalContextProps {
  daysRental: number;
  setDaysRental: (daysRental: number) => void;
  totalSum: number;
  setTotalSum: (totalSum: number) => void;
  office: OfficeWithoutSafes | Office | null;
  setOffice: (office: OfficeWithoutSafes | Office) => void;
  size: string;
  setSize: (size: string) => void;
  address: string;
  setAddress: (address: string) => void;
}

export const SafeRentalContext = createContext<SafeRentalContextProps | null>(
  null
);

export const SafeRentalContextProvider: React.FC<{ children: ReactNode }> = ({
  children,
}) => {
  const [daysRental, setDaysRental] = useState(1);
  const [totalSum, setTotalSum] = useState(1);
  const [office, setOffice] = useState<OfficeWithoutSafes | Office | null>(null);
  const [address, setAddress] = useState('');
  const [size, setSize] = useState('');

  return (
    <SafeRentalContext.Provider
      value={{
        daysRental,
        setDaysRental,
        totalSum,
        setTotalSum,
        office,
        setOffice,
        size,
        setSize,
        address,
        setAddress
      }}
    >
      {children}
    </SafeRentalContext.Provider>
  );
};
