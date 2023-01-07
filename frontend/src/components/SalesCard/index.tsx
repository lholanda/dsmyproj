import axios from "axios";
import { useEffect, useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { Sale } from "../../models/sales";
import { BASE_URL } from "../../utils/request";

import NotificationButton from "../NotificationButton";
import "./styles.css";

function SalesCard() {

  // reactHook - useState and useEffect 
  // qdo mudar um determinado dado, executa a funcao
  
  const min = new Date(new Date().setDate(new Date().getDate() - 365));
  const max = new Date();

  // declarar um dado e uma funcao que altera este dado minState and setMinDate
  const [minDate, setMinDate] = useState(min);
  const [maxDate, setMaxDate] = useState(max);

  const [sales, setSales] = useState<Sale[]>([]);

  // funcao e lista de dependencia
  useEffect(()=>{
    axios.get(`${ BASE_URL }/sales`).
    then(response => {
      //console.log(response.data.content)
      setSales(response.data.content)
    });
  }, []);

  return (
    <div className="dsmeta-card">
      <h2 className="dsmeta-sales-title">Vendas</h2>
      <div>
        <div className="dsmeta-form-control-container">
          <DatePicker
            selected={minDate}
            // para alterar o estado das datas dentro do Datepicker
            onChange={(date: Date) => setMinDate(date) }
            className="dsmeta-form-control"
            dateFormat="dd/MM/yyyy"
          />
        </div>
        <div className="dsmeta-form-control-container">
          <DatePicker
            selected={maxDate}
            onChange={(date: Date) => setMaxDate(date)}
            className="dsmeta-form-control"
            dateFormat="dd/MM/yyyy"
          />
        </div>
      </div>

      <div>
        <table className="dsmeta-sales-table">
          <thead>
            <tr>
              <th className="show992">ID</th>
              <th className="show576">Data</th>
              <th>Vendedor</th>
              <th className="show992">Visitas</th>
              <th className="show992">Vendas</th>
              <th>Total</th>
              <th>Notificar</th>
            </tr>
          </thead>
          <tbody>

            
            
            { sales.map(sale => { 
              // iteracao para cada valor de sale
              var dateFormated = new Date(sale.date).toUTCString();
              dateFormated = new Date(sale.date).toLocaleString();
              dateFormated = new Date(sale.date).toDateString();
              dateFormated = new Date(sale.date).toLocaleDateString();
              return (
                <tr key={sale.id}>    
                  <td className="show992">{sale.id}</td>
                  <td className="show576">{dateFormated}</td>
                  <td>{sale.sellerName}</td>
                  <td className="show992">{sale.visited}</td>
                  <td className="show992">{sale.deals}</td>
                  <td>R$ {sale.amount.toFixed(2)}</td>
                  <td>
                    <div className="dsmeta-red-btn-container">
                      <NotificationButton />
                    </div>
                  </td>
                </tr>
              )
             })}


          </tbody>
        </table>
      </div>
    </div>
  );
}

export default SalesCard;
