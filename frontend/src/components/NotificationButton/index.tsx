import axios from "axios";
import { toast } from "react-toastify";
import icon from "../../assets/img/notification-icon.svg"
import { BASE_URL } from "../../utils/request";
import "./styles.css"

type Props = {
  saleId: number;
  saleName: string;
  teste: number;
}

function handleClick(saleId: number, saleName: string, teste: number): void {
    axios(`${BASE_URL}/sales/${saleId}/notification`)
    .then( response => {
      toast.info("SMS enviado para " + saleName);
    });
} 

function NotificationButton( {saleId, saleName, teste} : Props) {

  return (
    <>
      <div className="dsmeta-red-btn" onClick={ () => handleClick(saleId, saleName, teste)}>
        <img src={icon} alt="Notificar" />
      </div>
    </>
  );
}

export default NotificationButton;
