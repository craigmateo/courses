<?php

class Vehicle {

    function __construct($make, $model, $year, $mileage, $price, $image)
    {
        $this->make = $make;
        $this->model = $model;
        $this->year = $year;
        $this->mileage = $mileage;
        $this->price = $price;
        $this->image = $image;
    }

    var $make;
    var $model;
    var $year;
    var $mileage;
    var $price;
    var $image;

}

class Truck extends Vehicle {

    function __construct($make, $model, $year, $mileage, $price, $image, $engine)
    {
        Vehicle::__construct($make, $model, $year, $mileage, $price, $image);
        $this->engine = $engine;
    }

    var $engine;
}

$vehicle1 = new Vehicle("Astro", "Estrella", "2021", 500, 50000.00, "veh-01.jpg");
$vehicle2 = new Vehicle("Terraza", "Spinneo", "2020", 30000, 31000.00, "veh-02.jpg");
$vehicle3 = new Vehicle("Sage", "Escotar", "2014", 70000, 15000.00, "veh-03.jpg");
$vehicle4 = new Truck("Hauler", "Lion", "2021", 200, 40000.00, "veh-04.jpg", "diesel");

$vehicles = [ $vehicle1, $vehicle2, $vehicle3, $vehicle4 ];

?>