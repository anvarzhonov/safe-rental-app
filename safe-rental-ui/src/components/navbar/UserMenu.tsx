import { useCurrentUserContext } from '@/hooks/context-hooks';
import useLoginModal from '@/hooks/useLoginModal';
import useRegisterModal from '@/hooks/useRegisterModal';
import { signOut } from '@/service/auth.service';
import { useRouter } from 'next/router';
import { useCallback, useState } from 'react';
import { AiOutlineMenu } from 'react-icons/ai';
import Avatar from './Avatar';
import MenuItem from './MenuItem';

const UserMenu = () => {
  const [isOpen, setIsOpen] = useState(false);
  const registerModal = useRegisterModal();
  const loginModal = useLoginModal();
  const router = useRouter();
  const { currentUser } = useCurrentUserContext();

  const toggleOpen = useCallback(() => {
    setIsOpen((value) => !value);
  }, []);

  const toggleLogOut = () => {
    signOut();
    router.push('/');
    router.reload();
  };

  return (
    <div className='relative'>
      <div className='flex flex-row items-center gap-3'>
        {currentUser && (
          <div
            onClick={() => router.push('/profile')}
            className='
                        hidden cursor-pointer 
                        rounded-full px-4 py-3 
                        text-sm font-semibold 
                        transition hover:bg-neutral-100 
                        md:block'
          >
            Личный кабинет
          </div>
        )}
        {/* <div
          onClick={() => router.push('/profile')}
          className='
                        hidden cursor-pointer 
                         px-4 py-3 
                        text-sm font-semibold 
                        transition hover:bg-neutral-100 
                        md:block'
        >
          
        </div> */}
        <div
          onClick={toggleOpen}
          className='flex cursor-pointer flex-row items-center gap-3 rounded-full border-[1px] border-neutral-200 p-4 hover:shadow-md md:px-2 md:py-1'
        >
          <AiOutlineMenu />
          <div className='hidden md:block'>
            <Avatar />
          </div>
        </div>
      </div>
      {isOpen && (
        <div className='absolute right-0 top-12 min-w-full overflow-hidden rounded-xl bg-white text-sm shadow-md '>
          <div className='flex cursor-pointer flex-col'>
            {currentUser ? (
              <>
                <MenuItem
                  label='Мои бронирования'
                  onClick={() => router.push('/trips')}
                />
                <MenuItem label='Выйти' onClick={toggleLogOut} />
              </>
            ) : (
              <>
                <MenuItem onClick={loginModal.onOpen} label='Войти в аккаунт' />
                <MenuItem onClick={registerModal.onOpen} label='Зарегистрироваться' />
              </>
            )}
          </div>
        </div>
      )}
    </div>
  );
};

export default UserMenu;
