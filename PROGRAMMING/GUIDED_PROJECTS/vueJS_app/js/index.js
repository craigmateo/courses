// extract the unique country names

const rawCountryList = universityJson.map(item => item.country);
const countryList = rawCountryList.filter((item, index, self) => self.indexOf(item) === index);
countryList.sort();

/* console.log(rawCountryList);
console.log(countryList); */

Vue.component("v-select", VueSelect.VueSelect);

var app = new Vue({
    el: "#vue-app",
    data: {
        // message: "Hello World!",
        countries: countryList,
        countrySelected: "",
        universities: [],
        universitySelected: null
    },

    methods: {
        fetchUniversities: function() {
            //console.log("fetchUniversities() called for " + this.countrySelected);

            let matches = universityJson.filter(item => item.country == this.countrySelected);
            matches.sort((lhs, rhs) => lhs.name < rhs.name ? -1 : 1);
            //console.log(matches);

            this.universities = matches;
        }
    }
});