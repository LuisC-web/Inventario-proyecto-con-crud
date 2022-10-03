const validando =
  //Validando correo
  (mail, password) => {
    if (/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/.test(mail)) {
      /*Validando Contraseña 
  Requisitos:
  *Una mayúscula
  *Una minuscula
  *Un número
  *Un caracter especial
  */
      if (
        /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])([A-Za-z\d$@$!%*?&]|[^ ]){6,15}$/.test(
          password
        )
      ) {
        return true;
      } else {
        return 'Debe tener una mayúscula, minuscula, número y caracter especial';
      }
    }
    return 'El correo es inválido';
  };

const validarVacio = (mail, password) => {
  if (mail === '') return false;
  if (password === '') return false;
  return true;
};

export { validando, validarVacio };
