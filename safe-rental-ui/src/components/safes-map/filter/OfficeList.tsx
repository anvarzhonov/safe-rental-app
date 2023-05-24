import { useSafeRentalContext } from '@/hooks/context-hooks';
import { Office } from '@/types/map-search.type';
import { Button } from '@mui/material';
import { useRouter } from 'next/router';
import { FC, useState } from 'react';

type OfficeListProps = {
  offices: Office[];
  handleSelectedOffice: (office: Office) => void;
};

const OfficeList: FC<OfficeListProps> = ({ offices, handleSelectedOffice }) => {
  const [selectedOfficeId, setSelectedOfficeId] = useState<number>();
  const {setOffice} = useSafeRentalContext();
  const router = useRouter();

  const toggleSelected = (office: Office) => {
    setSelectedOfficeId(office.id);
    handleSelectedOffice(office);
  };

  const handleSelected = (office: Office) => {
    setOffice(office);
    router.push('/rental-calc');
  };
  return (
    <div className='flex flex-col gap-4 font-mono'>
      {offices.map((office) => (
        <div
          className='group/item cursor-pointer hover:bg-slate-100'
          key={office.id}
          onClick={() => toggleSelected(office)}
        >
          <div className='text-xl font-bold'>{office.address}</div>
          <div className='text-base text-neutral-500'>
            Количество свободных сейфов: {office.safes.length}
          </div>

          {selectedOfficeId === office.id && (
            <div className='text-center'>
              <Button
                className='bg-green-500 text-white'
                onClick={() => handleSelected(office)}
              >
                Выбрать
              </Button>
            </div>
          )}
        </div>
      ))}
    </div>
  );
};

export default OfficeList;
