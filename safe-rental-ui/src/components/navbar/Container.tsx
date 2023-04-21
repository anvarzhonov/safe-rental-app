import { FC } from "react";

type ContainerProps = {
	children: React.ReactNode
}

const Container: FC<ContainerProps> = ({children}) => {
  return (
    <div className="max-w-[2520px] mx-auto xl:px-20 md:px-20 sm:px-2 px-2">
        {children}
    </div>
  )
}

export default Container;