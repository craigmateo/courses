const pi = 3.14;

const calculateArea = (choice,side,length,breadth,radius) =>{   
    let area = 0.0; 
    // write logic here
    switch (choice) {
        case ("square"):
            if (typeof side == "number") {
                area=side*4;
            }
            else {
                area=-1;
            }
            break;
        case ("rectangle"):
            if (typeof length == "number" && typeof breadth == "number") {
                area=length*breadth;
            }
            else {
                area=-1;
            }
            break;
        case "circle":
            if (typeof(radius)=="number") {
                area=pi*(radius**2);
            }
            else {
                area=-1;
            }
            break;
        default:
            area=-1;
      }

    // note that you check the values passed are not null before performing any operation on them

    return area
}
module.exports = {calculateArea}
