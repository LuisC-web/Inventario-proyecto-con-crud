
import { validando, validarVacio } from '../helpers/validando.js';

const $EMAIL = document.getElementById('email');
const $PASSWORD = document.getElementById('password');
const $BUTTONSUBMIT = document.getElementById('buttonSubmit');
const manejarSubmit = (e) => {
  e.preventDefault();
  console.log(validarVacio($EMAIL.value, $PASSWORD.value));
  if (!validarVacio($EMAIL.value, $PASSWORD.value))
    return alert('El correo o constraseña está vacio');
  if (validando($EMAIL.value, $PASSWORD.value) != true)
    alert(validando($EMAIL.value, $BUTTONSUBMIT.value));

  setInterval(() => {
    console.log('Llamando API');
  }, 5000);
};
document.addEventListener('DOMContentLoaded', (e) => {
  $BUTTONSUBMIT.addEventListener('click', (e) => manejarSubmit(e));
});

