import { useSafeRentalContext } from '@/hooks/context-hooks';
import { Input } from '@material-tailwind/react';
import Image from 'next/image';
import { useState } from 'react';

type Props = {};

const data = [
  {
    id: 1,
    sizeType: 'Маленький',
    size: 'XS',
    name: 'Item 1',
    info: 'Подходит для хранения небольших предметов, документов, ключей, ювелирных украшений без футляров.',
    pricePerDay: 150,
  },
  {
    id: 2,
    sizeType: 'Средний',
    size: 'S',
    name: 'Item 2',
    info: 'Подходит для хранения драгоценностей в футлярах, документов формата А4, стандартного слитка драгоценного металла, монет из драгоценных металлов весом 1 кг и более.',
    pricePerDay: 200,
  },
  {
    id: 3,
    sizeType: 'Большой',
    size: 'M',
    name: 'Item 3',
    info: 'Подходит для хранения предметов коллекционирования, сумок или портфелей с документами.',
    pricePerDay: 250,
  },
  {
    id: 4,
    sizeType: 'Очень большой',
    size: 'XL',
    name: 'Item 4',
    info: 'Подходит для хранения объемных предметов коллекционирования, дизайнерских изделий, шубит для хранения предметов коллекционирования, сумок или портфелей с документами.',
    pricePerDay: 250,
  },
];

const SizesInfo = () => {
  const [selectedSizeId, setSelectedSizeId] = useState(1);
  const { setSize } = useSafeRentalContext();

  const findSizeById = (id: number) => {
    return data.find((item) => item.id === id)!;
  };

  const getImagePath = (sizeType: string) => {
    return `/sizes/${sizeType}.svg`;
  };

  const handleSizeClick = (sizeId: number) => {
    setSelectedSizeId(sizeId);
    const sizeName = findSizeById(sizeId).sizeType;
    setSize(sizeName.toUpperCase());
  };

  return (
    <>
      <div className='sizes grid grid-cols-2 gap-4'>
        {data.map((size) => (
          <div key={size.id} className='safe-size'>
            <Input
              id={`${size.id}`} // приводим к string c помощью "+"
              className='peer/size hidden'
              type='radio'
              name='status'
              checked={selectedSizeId === size.id}
              onClick={() => handleSizeClick(size.id)}
            />
            <label
              htmlFor={`${size.id}`}
              className={`
							flex cursor-pointer flex-col
							gap-2 rounded-lg
							border 
							border-gray-600 hover:bg-slate-100 hover:text-green-400
						  peer-checked/size:border-red-500 peer-checked/size:text-green-500
   	 						${
                  selectedSizeId === size.id
                    ? 'border-green-600 bg-green-50 text-green-500'
                    : ''
                }
							p-3`}
            >
              <Image
                height={60}
                width={60}
                alt='Avatar'
                src={getImagePath(size.size)}
              ></Image>
              <span className='ml-2'>{size.sizeType}</span>
            </label>
          </div>
        ))}
      </div>
      <div className='size-info flex flex-col gap-3'>
        <div className='h-w-info'>
          <div className='hidden font-bold peer-checked/size:block'>
            свыше 20 см в высоту
          </div>
          <p className='text-xs font-light'>
            Размеры сейфов отличаются в каждом конкретном офисе.
          </p>
        </div>
        <div className='what-fill-info'>
          <p className='pb-1 font-bold'>Что поместится</p>
          {selectedSizeId !== null && (
            <p className='text-xs font-light leading-5'>
              {findSizeById(selectedSizeId).info}
            </p>
          )}
        </div>
      </div>
    </>
  );
};

export default SizesInfo;
