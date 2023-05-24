import MuiInput from '@mui/material/Input';
import Slider from '@mui/material/Slider';
import { styled } from '@mui/material/styles';

const PrettoSlider = styled(Slider)({
  color: '#52af77',
  height: 8,
  '& .MuiSlider-track': {
    border: 'none',
  },
  '& .MuiSlider-thumb': {
    height: 24,
    width: 24,
    backgroundColor: '#fff',
    border: '2px solid currentColor',
    '&:focus, &:hover, &.Mui-active, &.Mui-focusVisible': {
      boxShadow: 'inherit',
    },
    '&:before': {
      display: 'none',
    },
  },
  '& .MuiSlider-valueLabel': {
    lineHeight: 1.2,
    fontSize: 12,
    background: 'unset',
    padding: 0,
    width: 32,
    height: 32,
    borderRadius: '50% 50% 50% 0',
    backgroundColor: '#52af77',
    transformOrigin: 'bottom left',
    transform: 'translate(50%, -100%) rotate(-45deg) scale(0)',
    '&:before': { display: 'none' },
    '&.MuiSlider-valueLabelOpen': {
      transform: 'translate(50%, -100%) rotate(-45deg) scale(1)',
    },
    '& > *': {
      transform: 'rotate(45deg)',
    },
  },
});

type SliderProps = {
  daysRental: number;
  handleChange: any;
};

const NumberOfDaysSlider = ({ daysRental, handleChange }: SliderProps) => {

  return (
    <div className=''>
      <label htmlFor='days' className='mb-2 block font-medium'>
        Срок аренды
      </label>
      <div className='flex items-center gap-3'>
        <PrettoSlider
          className='w-3/4'
          valueLabelDisplay='auto'
          aria-label='pretto slider'
          value={daysRental}
          onChange={handleChange}
          defaultValue={1}
          min={1}
          max={1096}
        />
        <MuiInput
          value={daysRental}
          size='medium'
          onChange={handleChange}
          inputProps={{
            step: 1,
            min: 1,
            max: 1096,
            type: 'number',
            'aria-labelledby': 'input-slider',
          }}
        />
        <span>Дней</span>
      </div>
    </div>
  );
};

export default NumberOfDaysSlider;
