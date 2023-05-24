import { useSafeRentalContext } from '@/hooks/context-hooks';
import { TextField } from '@mui/material';
import { useRef, useState } from 'react';
import Cards, { Focused } from 'react-credit-cards-2';
import 'react-credit-cards-2/dist/es/styles-compiled.css';
import {
  formatCVC,
  formatCreditCardNumber,
  formatExpirationDate,
  formatFormData,
} from '../../utils/payment-utils';

interface ReactCreditCardsProps {
  cvc: string | number;
  expiry: string | number;
  focused?: Focused;
  name: string;
  issuer?: string | undefined;
  number: string | number;
  placeholders?:
    | {
        name: string;
      }
    | undefined;
  preview?: boolean | undefined;
}
const PaymentForm = () => {
  const [state, setState] = useState<ReactCreditCardsProps>({
    number: '',
    expiry: '',
    cvc: '',
    name: '',
    issuer: '',
    focused: 'number',
    placeholders: {
      name: 'ФИО',
    },
  });

  const [formData, setFormData] = useState<FormData | null>(null);

  const formRef = useRef<HTMLFormElement>(null);
  const { totalSum } = useSafeRentalContext();

  const handleInputChange = ({
    target,
  }: React.ChangeEvent<HTMLInputElement>) => {
    let value = target.value;
    const name = target.name;
    if (name === 'number') {
      value = formatCreditCardNumber(value);
    } else if (name === 'expiry') {
      value = formatExpirationDate(value);
    } else if (name === 'cvc') {
      value = formatCVC(value);
    }

    console.log('value: ' + value);
    setState((prev) => ({ ...prev, [name]: value }));
  };

  const handleInputFocus = (evt: any) => {
    setState((prev) => ({ ...prev, focused: evt.target.name }));
  };

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    const form = formRef.current;
    if (!form) {
      return;
    }
    const formData = Array.from(form.elements)
      .filter((el: Element): el is HTMLInputElement => el.tagName === 'INPUT')
      .reduce((acc: any, el: any) => {
        acc[el.name] = el.value;
        return acc;
      }, {});

    setFormData(formData);
    form.reset();
  };

  return (
    <div className='f'>
      <div className='flex min-h-screen items-center justify-center bg-blue-300 text-center'>
        <div className='mr-10'>
          <Cards
            number={state.number}
            expiry={state.expiry}
            cvc={state.cvc}
            name={state.name}
            placeholders={state.placeholders}
            focused={state.focused}
          />
        </div>
        <div className='h-auto w-2/4 rounded-lg bg-white p-3 '>
          <p className='text-xl font-semibold'>Детали оплаты</p>
          <form ref={formRef} onSubmit={handleSubmit}>
            <div className='mt-8'>
              <TextField
                fullWidth
                label='ФИО'
                id='name'
                name='name'
                onChange={handleInputChange}
                onFocus={handleInputFocus}
              />
            </div>
            <div className='mt-8'>
              <TextField
                fullWidth
                type='tel'
                label='0000 0000 0000 0000'
                id='number'
                name='number'
                onChange={handleInputChange}
                onFocus={handleInputFocus}
              />
            </div>
            <div className='mt-8 flex gap-5'>
              <div>
                <div>
                  <TextField
                    fullWidth
                    label='mm/yyyy'
                    id='expiry'
                    name='expiry'
                    onChange={handleInputChange}
                    onFocus={handleInputFocus}
                  />
                </div>
              </div>
              <div>
                <div>
                  <TextField
                    fullWidth
                    label='000'
                    id='cvc'
                    name='cvc'
                    type=''
                    onChange={handleInputChange}
                    onFocus={handleInputFocus}
                  />
                </div>
              </div>
            </div>

            <p className='mt-4 text-center text-lg font-semibold text-gray-600'>
              Итоговая сумма: {totalSum}
              <span className='ml-1 font-extrabold'>₽</span>
            </p>
            <div className='mt-4 flex justify-center'>
              <button
                className='pay mb-3 h-12 
                                w-1/2 cursor-pointer rounded-lg 
                                bg-orange-600 text-white outline-none 
                                transition-all hover:bg-orange-700'
              >
                Оплатить
              </button>
            </div>
          </form>
          {formData && (
            <div className='App-highlight3'>
              {formatFormData(formData).map((d, i) => (
                <div key={i}>{d}</div>
              ))}
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

export default PaymentForm;
