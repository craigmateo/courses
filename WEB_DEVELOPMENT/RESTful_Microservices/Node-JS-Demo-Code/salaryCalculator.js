var name = process.argv[2]
var age = parseInt(process.argv[3])
var basicSalary = parseFloat(process.argv[4])

const hra = (50 * basicSalary) / 100
const specialAllowance = (30 * basicSalary) / 100
const pf = (12 * basicSalary) / 100

let grossSalary = (basicSalary + hra + specialAllowance) - pf

let annualgrossSalary = 12 * grossSalary

console.log(`Annual gross income of ${name} is ${annualgrossSalary}`)