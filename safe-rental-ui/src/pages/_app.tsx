import Layout from '@/components/layout/Layout';
import { CurrentUserContextProvider } from '@/contexts/CurrentUserContext';
import { SafeRentalContextProvider } from '@/contexts/SafeRentalContext';
import '@/styles/globals.css';
import type { AppProps } from 'next/app';

export default function App({ Component, pageProps }: AppProps) {
  return (
    <>
      <CurrentUserContextProvider>
        <Layout>
          <SafeRentalContextProvider>
            <Component {...pageProps} />
          </SafeRentalContextProvider>
        </Layout>
      </CurrentUserContextProvider>
    </>
  );
}
