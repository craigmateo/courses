# Week 7 Quiz
![](https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://coursera-course-photos.s3.amazonaws.com/b8/f13d23685c4f8ca8d2a1077826d6b0/Navigation-Thimnail.png?auto=format%2Ccompress&dpr=1&w=256&h=32)

1. The minimum distance classifier is (choose one)

- [ ] A binary classifier
- [x] A multi-class classifier

That is correct.  It can separate many classes using linear decision surfaces.

2. In the support vector machine what is the margin in a two-class data set?

- [ ] The distance between the data set means
- [x] The distance between two hyperplanes that just touch pixels in the opposing classes
- [ ] A combination of the previous two answers

That is correct, by definition.

3. The fundamental support vector machine algorithm is (choose one)

- [ ] A multi-class classifier
- [x] A binary linear classifier
- [ ] A binary non-linear classifier

Yes that is correct.

4. Support vectors are (choose one)

- [ ] A random set of training pixels taken from each of two classes
- [x] A set of training pixels which lie on a pair of marginal hyperplanes
- [ ] The pair of class means

That is correct, by definition and are the result of the training process

5. In the support vector machine the regularisation parameter (choose one):

- [ ] Ensures that the marginal hyperplanes stay in position
- [ ] Removes the influence of pixels on the wrong side of the separating hyperplane
- [x] Balances maximising the margin between classes and the allowed overlap of pixels

6. The role of the kernel in the support vector machine is to (choose one)

- [x] Allow the SVM to handle binary data sets that are not linearly separable
- [ ] Minimise errors caused by classes which overlap the linear decision surface
- [ ] Make it into a multi-class machine


7. To use kernels with a support vector machine it is important to know the form of the underlying transformation (choose the correct answer)

- [ ] True
- [x] False


8. Grid searching is a procedure for (choose one)

- [ ] Selecting training data
- [ ] Choosing a multi-class strategy
- [x] Finding acceptable values for the kernel and regularisation parameters

That is correct.

9. The support vector classifier is preferable to the maximum likelihood classifier for hyperspectral data sets because (choose one)

- [ ] The concept of a covariance matrix does not exist for hyperspectral data
- [ ] It is easier to estimate the elements of a covariance matrix using the SVM
- [x] The SVM does not require the use of covariance matrices

That is correct, therefore the problem of the Hughe's phenomenon is less important.

10. The minimum distance classifier is faster than the maximum likelihood classifier in remote sensing applications because (choose one)

- [x] A covariance matrix is not involved in its discriminant function
- [ ] It only involves the products of integers and not real numbers
- [ ] It only involves a diagonal covariance matrix

That is correct, so it is faster to compute.
