import CurrentUserContext from "@/contexts/CurrentUserContext";
import { SafeRentalContext } from "@/contexts/SafeRentalContext";
import { useContext } from "react";

export const useSafeRentalContext = () => useContext(SafeRentalContext)!;
export const useCurrentUserContext = () => useContext(CurrentUserContext)!;