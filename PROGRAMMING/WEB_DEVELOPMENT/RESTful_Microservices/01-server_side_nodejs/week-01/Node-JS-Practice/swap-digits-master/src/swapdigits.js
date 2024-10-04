const swapDigits = (number)=>{
    let swappedNumber = 0;
    //write logic here
    var newNumString = "";
    var numAsString = number.toString();

    if (number < 0) {
        swappedNumber = 0;
    }

    else if (numAsString.length % 2 == 0) {
        swapDigits(numAsString);
        swappedNumber=parseInt(newNumString);
    }

    else {
        var firstDigit = numAsString.substring(0,1);
        var numFirstRemoved = numAsString.slice(1);
        swapDigits(numFirstRemoved);
        newNumStringOdd=firstDigit+newNumString;
        swappedNumber=parseInt(newNumStringOdd);
    }

    return swappedNumber;

    function swapDigits(numString) {
        var max = numString.length;
        for (let i = 0; i < max-1; i += 2) {
            pair = numString.substring(i+1,i+2) + numString.substring(i,i+1);
             newNumString+=pair;
        }
    }

}

module.exports = swapDigits
