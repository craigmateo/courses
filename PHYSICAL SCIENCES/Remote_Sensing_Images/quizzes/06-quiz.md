# Week 6 Quiz
![](https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://coursera-course-photos.s3.amazonaws.com/b8/f13d23685c4f8ca8d2a1077826d6b0/Navigation-Thimnail.png?auto=format%2Ccompress&dpr=1&w=256&h=32)

1. When labelled pixels are available to train a classifier algorithm, the procedure is called:

- [ ] Unsupervised classification
- [x] Supervised classification

Yes that is correct.  The analyst supervises the algorithm's learning through the presentation of training pixels.

2. Information classes are (choose one):

- [x] A property of the scene being imaged
- [ ] A property of the image itself
- [ ] The same as spectral classes

Yes that is correct.  They are the classes that the analyst observes to be in the region of the earth being imaged.

3. The prior probabilities used with a maximum likelihood classifier are (choose one):

- [x] A property of the scene being imaged.
- [ ] A property of the image itself
- [ ] An arbitrary choice by the analyst.


That is not correct.  They are properties of the scene being imaged, but not the image.

4. Spectral classes are (choose one):

- [ ] A property of the scene being imaged
- [x] A property of the image itself
- [ ] A normal distribution

Yes that is correct.  They are sometimes also called data classes for the same reason.

5. With the maximum likelihood classifier, if the prior probabilities are all equal then

- [x] Posterior probabilities are not important
- [ ] Posterior probabilities are important.
- [ ] Spectral classes are not important

That is correct because class decisions are then made using the class conditional probabilities.

6. The maximum likelihood classifier may suffer when the number of training samples is small because of

- [ ] The difficulty in estimating the mean vector accurately
- [x] The difficulty in estimating the covariance matrix reliably
- [ ] The difficulty in estimating both the mean  vector and the covariance matrix accurately.


7. The decision surface for the maximum likelihood classifier is (choose one):

- [ ] A linear function
- [x] A quadratic function
- [ ] An exponential function

That is correct.

8. A decision rule (choose one)

- [ ] is important when training a classifier
- [x] is important when using a classifier to label an unknown pixel
- [ ] separates one classifier algorithm from another


9. The maximum likelihood classifier degenerates to a minimum distance classifier when (choose one)

- [ ] When the prior probabilities are all the same.
- [x] When the covariance matrices of all the classes are the identity matrix
- [ ] When the prior probabilities are all the same and the covariance matrices are all the identity matrix.

10.  The multidimensional normal distribution is used as the basis for maximum likelihood classification in remote sensing because:

- [ ] Information classes are naturally multidimensional normally distributed
- [ ] Spectral classes are naturally multidimensional normally distributed
- [x] The properties of the normal distribution are well known and it is good basis on which to build more complex class models (for example, as sums of Gaussians)

That is correct, and is why the normal distribution model is so widely adopted.
