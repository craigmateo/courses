# Week 12 Quiz
![](https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://coursera-course-photos.s3.amazonaws.com/b8/f13d23685c4f8ca8d2a1077826d6b0/Navigation-Thimnail.png?auto=format%2Ccompress&dpr=1&w=256&h=32)

1. The error matrix (choose one)

- [ ] represents classifier performance on training data
- [x] represents classifier performance on testing data
- [ ] is neither of the above

That is correct.&nbsp; The error matrix is computed from the classifier performance on testing data.

2. The measure derived from the error matrix called user’s accuracy is a good measure of the accuracy of a thematic map if (choose one):

- [ ] sufficient testing pixels have been used
- [ ] we assume equal prior probabilities of the map classes
- [x] if the distribution of testing pixels by class is indicative of the true ground proportions

That is correct

3. Even though a particular classifier might perform very well on a small class, there can be considerable error in that class on the resulting thematic map because (choose one):

- [ ] we have assumed equal class prior probabilities in the map
- [x] there are large errors of commission into that class in the classifier’s labelling of larger classes
- [ ] there are large errors of omission from that class in the classifier’s performance

That is correct.&nbsp; If there are large errors of commission into that class from other large classes, then the map accuracy of that class will be poor.

4. The overall accuracy of a classification exercise, computed from the diagonal elements of the error matrix is the same as (choose one)

- [ ] the average producer’s accuracy
- [ ] the average user’s accuracy
- [x] neither of the above

5. If the accuracy of a thematic map was known to be extremely good, and close to 100%, the theoretical number of independent testing pixels needed per class to assess the actual accuracy (choose one):

- [x] Can be very small—just a few
- [ ] must be at least 100 per class
- [ ] must be chosen in proportion to the class prior probabilities

That is correct.&nbsp; A small number of tests is sufficient to detect a large proportion of correctly labelled pixel.  In principle, if the map was exactly 100% correct then only one sample is needed even though we wouldn't actually know that to be the case beforehand.  Actually, if we knew it was 100% correct we wouldn't take testing samples!

6. A vegetation index is important because (choose one)

- [x] it summarises the green vegetation cover of a pixel in a single measure
- [ ] green leaf vegetation cannot be determined in any other way
- [ ] it works even with cloud cover

That is correct.

7. To assess the accuracy of a thematic map it is better to (choose one):

- [ ] use the accuracy of the classifier that created the map
- [x] sample the map itself, class by class, using testing pixels
- [ ] use an average of the measures above

That is correct and is the preferred method in practice

8. Cross validation as a method for assessing classifier performance uses (choose one):

- [x] a single set of labelled reference data
- [ ] separate training and testing sets of reference data
- [ ] neither, since it is an unsupervised technique

That is correct

9. Cross validation as a method for assessing classifier performance can be costly and time consuming because (choose one)

- [ ] sorting the reference data into partitions is time consuming
- [x] the classifier has to be trained as many times as there are partitions of the reference data

That is correct and can be a very large number, depending on the partitioning chosen by the analyst.

10. When using clustering to identify sets of spectral classes for a subsequent supervised classification, the regions to be clustered should be

- [ ] single information classes, as much as possible
- [ ] the whole image
- [x] inclusive of all the apparent information classes in the image, including edge pixels

That is correct, and gives the best set of spectral classes (clusters) in practice, including the separate clusters represented by the mixtures of classes often found on class boundaries and in mixed regions of a scene.
