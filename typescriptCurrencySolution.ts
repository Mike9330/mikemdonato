let unique=(str)=> {
	let strArr = str.split("")

	return strArr[0] !== strArr[1] && strArr[1] !== strArr[2];
}

var pattern = new RegExp("([A-Z]+)([0-9]{4})([0-9])([A-Z]+");

var totalValue = 0;

var denominations = ["10", "20","50","100","200","500","1000"];

serialNumber.forEach(num => {
	var res = pattern.exec(num);
	
})