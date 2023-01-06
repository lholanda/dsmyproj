import logo from "../../assets/img/logo.svg"
import "./styles.css"

function Header() {
  return (
    <header>
      <div className="dsmeta-logo-container">
        <img src={logo} alt="DSMeta" />
        <h1>DSMyProj</h1>
        <p>
          Desenvolvido por
          <a href="https://www.lhdev.com/"> Luiz Holanda</a>
        </p>
      </div>
    </header>
  );
}

export default Header;
