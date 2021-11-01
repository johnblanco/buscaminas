function updateCellClicked(element) {
	document.getElementById('clicked-cell').value = element.id;
	document.getElementById('cellForm').submit();
}
