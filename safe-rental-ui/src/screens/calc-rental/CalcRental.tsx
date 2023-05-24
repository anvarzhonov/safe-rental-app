import { useSafeRentalContext } from '@/hooks/context-hooks';
import { Button } from '@mui/material';
import { useRouter } from 'next/router';
import { useEffect, useState } from 'react';
import NumberOfDaysSlider from './NumberOfDaysSlider';
import SizesInfo from './SizesInfo';

const data = [
  {
    termFrom: 1,
    termTo: 30,
    pricePerDay: 100,
  },
  {
    termFrom: 31,
    termTo: 180,
    pricePerDay: 200,
  },
  {
    termFrom: 181,
    termTo: 360,
    pricePerDay: 300,
  },
  {
    termFrom: 361,
    termTo: 1096,
    pricePerDay: 400,
  },
];
const CalcRental = () => {
  const [pricePerDay, setPricePerDay] = useState<number[]>([]);
  const {office, daysRental, setDaysRental, totalSum, setTotalSum} = useSafeRentalContext();
  const router = useRouter();

  useEffect(() => {
    const filteredData = data.filter(
      (x) => daysRental >= x.termFrom && daysRental <= x.termTo
    );

    const price = filteredData.map((x) => x.pricePerDay);

    setPricePerDay(price);

    const total =
      pricePerDay.reduce((acc, cur) => acc + cur, 100) * daysRental;

    setTotalSum(total);
  }, [daysRental]);

  const handleChange = (event: any) => {
    const selectedDays = event.target.value;
    setDaysRental(selectedDays);
  };

  const handleRentButton = (event: any) => {
    event.preventDefault();

    setTotalSum(totalSum);
    setDaysRental(daysRental);

    router.push('/rental-total');
  };

  return (
    <div className='container mx-auto font-mono'>
      <div className='py-5 text-center text-3xl font-bold'>
        Расчет стоимости аренды
      </div>
      <div className='flex justify-center gap-3'>
        <div className='calc-info flex w-1/2 flex-col gap-4 rounded border-x-4 border-sky-500 px-5 shadow-md'>
          <div className='city-info'>
            Выбранное отделение: <span className='font-bold'>{office?.address}</span>
          </div>
          <NumberOfDaysSlider
            daysRental={daysRental}
            handleChange={handleChange}
          />
          <SizesInfo />
        </div>
        <div className='total-sum flex flex-col'>
          <div className='days-rental-info'>Аренда за {daysRental} дней</div>
          <div className=''>Тариф при выбранном сроке: {pricePerDay}</div>
          <div className='sum-rental-info'>
            {totalSum} <span className='font-extrabold'>₽</span>
          </div>

          <div className='rent-button pt-10 text-center'>
            <Button
              variant='contained'
              className='bg-green-600'
              onClick={handleRentButton}
            >
              Арендовать
            </Button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CalcRental;
