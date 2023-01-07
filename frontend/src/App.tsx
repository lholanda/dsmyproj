// import em todos os componentes
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

import Header from "./components/Header";
import SalesCard from "./components/SalesCard";

function App() {
  return (
    // precisa informar o componente <ToastContainer/> no App.tsx
    <>
      <ToastContainer />
      <Header />
      <main>
        <section id="sales">
          <div className="dsmeta-container">
            <SalesCard />
          </div>
        </section>
      </main>
    </>
  );
}

export default App;
