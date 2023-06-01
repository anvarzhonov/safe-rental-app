import AgreementModal from '@/components/modals/AgreementInfoModal';
import useLoginModal, { useAgreementModal } from '@/hooks/useLoginModal';
import getUserAgreements from '@/service/agreement.service';
import { AgreementInfo } from '@/types/agreement.type';
import { useEffect, useState } from 'react';
import { toast } from 'react-hot-toast';

type Props = {};

const style = {
  position: 'absolute' as 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 10,
  p: 4,
};

const ProfileScreen = (props: Props) => {
  const [agreementInfos, setAgreementInfos] = useState<AgreementInfo[]>([]);
  const formattedDate = new Date().toISOString().split('T')[0];
  const loginModal = useLoginModal();

  const agreementModal = useAgreementModal();
  const [open, setOpen] = useState(false);

  const handleOpen = () => {
    console.log('21-21');
    agreementModal.onOpen();
  };
  const handleClose = () => setOpen(false);

  const agreement2: AgreementInfo = {
    agreementNumber: '23932-32921-3913',
    rentEndDate: '2023-05-25',
    rentStartDate: '2023-05-10',
    safeSize: 'Большой'
  };

  useEffect(() => {
    const fetchAgreements = async () => {
      const response = await getUserAgreements();
      if (response.status === 200) {
        const agreements = response.data!;

        setAgreementInfos(agreements);
      } else {
        toast.error(
          'Произошла ошибка во время загрузки договоров: ' +
            JSON.stringify(response.errMessage)
        );
        loginModal.onOpen();
      }
    };

    fetchAgreements();
  }, []);

  return (
    <div className='container mx-auto mt-5'>
      <h1 className='text-center'>Имеющиеся договора</h1>
      {agreementInfos.length === 0 ? (
        <p>У вас еще нет оформленных договоров. Арендовать сейф сейчас</p>
      ) : (
        // <div className='flex gap-4 flex-col mt-10'>
        //   {agreementInfos.map((agreement) => (
        //     <div key={agreement.agreementNumber} className='flex gap-7 border-y'>
        //       <p>Дата начала: {agreement.rentStartDate}</p>
        //       <p>Дата окончания: {agreement.rentEndDate}</p>
        //       <p>Номер договора: {agreement.agreementNumber}</p>
        //       <p>Safe Size: {agreement.safeSize}</p>
        //     </div>
        //   ))}
        // </div>
        <div className='mt-10 flex justify-between gap-5'>
          <AgreementModal agreement={agreement2} />
          {agreementInfos.map((agreement) => (
            <div
              onClick={handleOpen}
              className='
                      h-24 w-[250px] 
                      cursor-pointer text-center 
                      shadow-md hover:text-slate-700 hover:opacity-50 focus:outline-none
                      focus:ring
                      '
            >
              <p className='text-lg'>{agreement.agreementNumber}</p>
              <p>
                Истекает{' '}
                <span className='font-bold'>{agreement.rentEndDate}</span>
              </p>
              <p className='mt-5 font-light'>Узнать подробнее</p>
              {/* <Modal
                className='bg-neutral-800/70'
                open={open}
                onClose={handleClose}
                aria-labelledby='modal-modal-title'
                aria-describedby='modal-modal-description'
              >
                <Box sx={style}>
                  <Typography
                    id='modal-modal-title'
                    variant='h6'
                    component='h2'
                  >
                    Text in a modal
                  </Typography>
                  <Typography id='modal-modal-description' sx={{ mt: 2 }}>
                    Duis mollis, est non commodo luctus, nisi erat porttitor
                    ligula.
                  </Typography>
                </Box>
              </Modal> */}
            </div>
          ))}
          {/* <table className='mx-auto mt-10 table-auto'>
            <thead>
              <tr>
                <th className='px-4 py-2'>Дата начала</th>
                <th className='px-4 py-2'>Дата окончания</th>
                <th className='px-4 py-2'>Номер договора</th>
                <th className='px-4 py-2'>Safe Size</th>
              </tr>
            </thead>
            <tbody>
              {agreementInfos.map((agreement) => (
                <tr key={agreement.agreementNumber}>
                  <td className='border px-4 py-2'>
                    {agreement.rentStartDate}
                  </td>
                  <td className='border px-4 py-2'>{agreement.rentEndDate}</td>
                  <td className='border px-4 py-2'>
                    {agreement.agreementNumber}
                  </td>
                  <td className='border px-4 py-2'>{agreement.safeSize}</td>
                </tr>
              ))}
            </tbody>
          </table> */}
        </div>
      )}
    </div>
  );
};

export default ProfileScreen;
