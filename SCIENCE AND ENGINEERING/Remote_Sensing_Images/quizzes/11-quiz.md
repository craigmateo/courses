# Week 11 Quiz
![](https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://coursera-course-photos.s3.amazonaws.com/b8/f13d23685c4f8ca8d2a1077826d6b0/Navigation-Thimnail.png?auto=format%2Ccompress&dpr=1&w=256&h=32)

1. Reducing the number of features to use in a classification is important because (choose one):

- [ ] features in the full set may interfere with each other
- [x] fewer training samples per class are needed if the feature set is smaller
- [ ] Displaying the image is easier

That is correct.  There is then less likelihood of obtaining poor estimates of the classifier parameters.

2. The principal components transformation is good for feature reduction when (choose one):

- [x] the classes of interest lie approximately along the principal diagonal of the data in spectral space
- [ ] the number of features has already been reduced a bit by some other method
- [ ] there is a low correlation among the original set of features

That is correct because the data then shows a high degree of correlation, which is resolved by the principal components transform.

3. What is imaging spectroscopy?

- [ ] a method where images are examined for spectral content in a laboratory
- [x] a techniques for recording sampled pixel spectra in image format
- [ ] imaging with two completely different image types—such as radar and thermal data

That is correct.  Imaging spectrometers (hyperspectral imagers) record a spectrum for each pixel

4. Reducing the number of features to be used in a classification, by transforming the data and then choosing the best transformed features, is best described as:

- [ ] feature selection
- [ ] feature transformation
- [x] feature reduction

That is correct.  After transformation we can then reduce the number of features

5. When displayed in image format, the correlation matrix for a hyperspectral image will show regions of high correlation existing in blocks, mostly down the diagonal.&nbsp; That is because (choose one):

- [x] adjacent bands of data are most likely to be highly correlated
- [ ] the maximum likelihood classifier requires the correlation matrix to look like that
- [ ] the hyperspectral sensor is designed to make that happen for all images

That is correct.  In fact the correlations can extend out over sets of adjacent bands.

6. If you were to use the maximum likelihood classifier to produce a thematic map from an image data set with 6 bands, and wanted to reduce the number of features beforehand, would your chosen feature reduction method be (choose one):

- [ ] ReliefF
- [ ] the principal components transformation
- [x] canonical analysis

That is correct. With only six bands good estimates of the class covariance matrices should be possible, allowing canonical analysis to be used with confidence.

7. If you were to use a support vector classifier to produce a thematic map from an image data set with 200 bands, and wanted to reduce the number of features beforehand, would your chosen feature reduction method be (choose one):

- [x] ReliefF
- [ ] the principal components transformation
- [ ] canonical analysis

That is correct.  ReliefF is a good method to use with hyperspectral data sets and classifiers that don't use class covariance information.

8. An example of a distribution free feature reduction technique is (choose one)

- [ ] the use of transformed divergence
- [ ] canonical analysis
- [x] non-parametric discriminant analysis

That is correct.&nbsp; No class distribution model is assumed

9. Which one of the following measures of separability is best in terms of computation time and effectiveness?

- [ ] JM distance
- [ ] Divergence
- [x] Transformed divergence

10.  The principal components transformation does not improve the intrinsic separability of a data set

- [x] true?
- [ ] false?

That is correct.&nbsp; All that PC does is represent the data in a different set of axes, in which the classes project with good separation in a space of reduced dimensionality.
