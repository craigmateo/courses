<!doctype html>

<!-- Web page "Hello World Autos"       -->
<!-- Created by Harrison Kong           -->
<!-- Copyright (C) Coursera 2021        -->

<html lang="en">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv=ÂPragmaÂ content=Âno-cacheÂ>
<meta http-equiv=ÂExpiresÂ content=Â-1?>
<meta http-equiv=ÂCACHE-CONTROLÂ content=ÂNO-CACHEÂ>
<!-- CSS Stylesheets -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="css/payment-plan.css">
<?php include "utilities.php" ?>
<title>Hello World Autos</title>   

</head>

<body>

    <h1>Your Personalised Payment Plan</h1>

    <div class="content-area">
        <img class="hero" src="images/<?php echo $_POST['image'] ?>" alt="vehicle image" />
        <p class="vehicle-make"><?php echo $_POST['make'] ?></p>
        <p class="vehicle-model"><?php echo $_POST['model'] ?></p>
        <hr class="vehicle-hr">
        <p class="vehicle-price">$<?php echo number_format($_POST['price'], 2) ?></p>
        <p><span class="data-label">Repayment duration: </span><span class="data-item"><?php echo $_POST['repayment-duration'] ?> months</span></p>
        <p><span class="data-label">Interest rate: </span><span class="data-item"><?php echo $_POST['interest-rate'] ?>% APR</span></p>
        <p><span class="data-label">Total payment: </span><span class="data-item">$<?php echo number_format(calculateTotalPayment($_POST['price'], $_POST['repayment-duration'], $_POST['interest-rate']), 2)?></span></p>
        <p><span class="data-label">Total interest: </span><span class="data-item">$<?php echo number_format(calculateTotalInterest($_POST['price'], $_POST['repayment-duration'], $_POST['interest-rate']), 2)?></span></p>
        <hr class="short-line">
        <p><span class="data-label">Monthly payment: </span><span class="focal-point">$<?php echo number_format(calculateMonthlyPayment($_POST['price'], $_POST['repayment-duration'], $_POST['interest-rate']), 2)?></span></p>
        <br /><br />
    </div>

</body>

<footer>
    <?php include "footer.php" ?>
</footer>

</html>