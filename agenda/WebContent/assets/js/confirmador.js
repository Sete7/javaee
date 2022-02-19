/**
 * Confirmacao de exclusao de dados
 * @author Junio Santos
 * @param idcon
 */

function confirmar(idcon) {
	let resposta = confirm("Confirma a exclusao deste contato?")
	if (resposta === true) {
		window.location.href = "delet?idcon=" + idcon
	}

}
