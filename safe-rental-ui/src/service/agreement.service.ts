import { AgreementInfo } from "@/types/agreement.type";
import { getAPI } from "./api/http-common";

export default async function getUserAgreements() {
  return await getAPI<AgreementInfo[]>('agreement/get', true)
//   .then(data => console.log(data))
//   .catch(err => console.log(err));
}
