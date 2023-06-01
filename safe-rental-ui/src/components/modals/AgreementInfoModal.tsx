'use client';

import { useState } from 'react';

import { useAgreementModal } from '@/hooks/useLoginModal';
import { AgreementInfo } from '@/types/agreement.type';
import Heading from '../Heading';
import Modal from './Modal';

interface LoginModalProps {
  agreement: AgreementInfo;
  isOpen?: boolean;
  onClose?: boolean;
}

const AgreementModal: React.FC<LoginModalProps> = ({ agreement }) => {
  const [isLoading, setIsLoading] = useState(false);
  const agreementModal = useAgreementModal();

  const bodyContent = (
    <div className='flex flex-col gap-4'>
      <Heading title='Номер договора' subtitle={agreement.agreementNumber} />
      <div className='mt-10 flex flex-col gap-4'>
        <div key={agreement.agreementNumber} className='flex gap-7 border-y'>
          <p>Дата начала: {agreement.rentStartDate}</p>
          <p>Дата истечения : {agreement.rentEndDate}</p>
          <p>Размер: {agreement.safeSize}</p>
        </div>
      </div>
    </div>
  );

  const footerContent = (
    <div className='mt-3 flex flex-col gap-4'>
      <hr />
      <div
        className='
      mt-4 text-center font-light text-neutral-500'
      ></div>
    </div>
  );

  return (
    <Modal
      disabled={isLoading}
      isOpen={agreementModal.isOpen}
      title='Информация по договору'
    //   actionLabel=''
      onClose={agreementModal.onClose}
      onSubmit={() => {}}
      body={bodyContent}
      footer={footerContent}
    />
  );
};

export default AgreementModal;
