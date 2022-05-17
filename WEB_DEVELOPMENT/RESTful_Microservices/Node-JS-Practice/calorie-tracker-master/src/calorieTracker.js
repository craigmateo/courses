const calculateWeightLostInAMonth = (cycling, running, swimming, extraCalorieInTake) => {
    let weightLostInAMonth = 0;

    // write logic here
    if (typeof cycling == 'number' && typeof running == 'number' && running > 0 && typeof swimming == 'number' && swimming > 0 && typeof extraCalorieInTake == 'number') {
        var calburnCycling = cycling * 8;
        var calburnRunning = running * 8;
        var calburnSwimming = swimming * 8;
        var calextraIntake = extraCalorieInTake * 30;

        var burntCalories = calburnCycling + calburnRunning + calburnSwimming;
        weightLostInAMonth = (burntCalories - calextraIntake) / 1000;

        return weightLostInAMonth;
    } else {
        return -1
    }
}

module.exports = calculateWeightLostInAMonth