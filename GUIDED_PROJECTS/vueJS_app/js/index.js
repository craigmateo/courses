// extract the unique country names

const rawCountryList = universityJson.map(item => item.country);
const countryList = rawCountryList.filter((item, index, self) => self.indexOf(item) === index);
countryList.sort();

console.log(rawCountryList);
console.log(countryList);

Vue.component("v-select", VueSelect.VueSelect);

var app = new Vue({
    el: "#vue-app",
    data: {
        // message: "Hello World!",
        countries: countryList
    }
});