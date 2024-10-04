# Week 4 Quiz
![](https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://coursera-course-photos.s3.amazonaws.com/b8/f13d23685c4f8ca8d2a1077826d6b0/Navigation-Thimnail.png?auto=format%2Ccompress&dpr=1&w=256&h=32)

1. In remote sensing image classification the information class labels are (choose the correct answer)

- [x] selected by the analyst having in mind a particular application 
- [ ] inherent properties of the recorded image data
That is correct.  Information classes are defined by the analyst

2. In setting up a machine classification exercise, human knowledge is (choose the most appropriate one)

- [ ] not required
- [ ] Needed for the selection of training samples
- [x] needed for several steps in training, classification and testing
That is correct.  Human knowledge is required at many places in training, testing and refining a classifier

3. Machine classification is effectively (choose one)

- [x] a segmentation of the spectral space into distinct regions
- [ ] a segmentation of the spectral space into overlapping regions
- [ ] attaching a class label to every individual data point in spectral space
That is correct

4. In a two-dimensional spectral space the mean vector of a group of pixels is (choose the correct answer)

- [ ] a scalar
- [x] a vector
- [ ] either a scalar or a vector

5. The expectation operator (choose one)

- [ ] calculates correlation
- [ ] calculates covariance
- [x] calculates the mean or average

6. x and y are two column vectors.  What is the product of x transposed multiplied by y?

- [ ] a row vector
- [x] a scalar
- [ ] a matrix
That is correct.  If the transpose is on the first vector the result will be a scalar.  If it is on the second vector the result will be a matrix.

7. If the covariance matrix of an image were diagonal we could conclude (choose one)

- [ ] the bands are highly correlated
- [x] there is no correlation among the bands
- [ ] the correlation matrix will not be diagonal
That is correct, because the off-diagonal elements indicate band-to-band correlations.

8. The principal components transformation is just a rotation of axes because (choose one)

- [x] the principal components values are linear combinations of the original brightness values in the image
- [ ] the eigenvalues decrease monotonically
- [ ] the principal components values are linear combinations of the original brightness values in the image, and the resulting covariance matrix is diagonal
That is correct.

9. The total image variance (pixel scatter) is the same for the original set of bands and the principal components of an image (true or false)

- [x] true
- [ ] false
That is correct, because the transform is a simple axis rotation.

10. When carrying out computer classification a training set of pixels is used to develop the classifier and a testing set of pixels is used to see how well it performs.&nbsp; How should the training and testing pixel sets be related?

- [ ] in fact they could be the same; there is no need to two separate sets of data
- [ ] provided the number of testing pixels is much larger than the set of training pixels it doesn’t matter how they are related.
- [x] they shouldn't be related; both sets should be a set of randomly selected samples form each class
That is correct.  A true test of classifier performance requires data that is independent of the set used to train the classifier.
