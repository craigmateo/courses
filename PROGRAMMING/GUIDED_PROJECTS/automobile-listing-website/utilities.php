<?php

function calculateMonthlyPayment($principal, $numMonth, $rate) {

    // in case your wonder, the formula is

    // A = P * r(1+r)^n / ((1+r)^n - 1)
    //
    // where A is the periodic payment
    // P is the principal
    // r is the periodic interest rate and
    // n is the number of periods

    $r = $rate / 100 / 12;

    $onePlusRN = pow((1 + $r), $numMonth);

    return $principal * $r * $onePlusRN / ($onePlusRN - 1);

}

// define a function called calculateTotalPayment
// it takes the same arguments as the one from above
// it calls calculateMonthlyPayment
// and then multiply it by number of months
// then returns the value


// define a function called calculateTotalInterest
// it takes the same arguments as the one from above
// it calls calculateTotalPayment
// and then subtract the principal from it
// then returns the value


?>