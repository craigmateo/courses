# Week 5 Quiz
![](https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://coursera-course-photos.s3.amazonaws.com/b8/f13d23685c4f8ca8d2a1077826d6b0/Navigation-Thimnail.png?auto=format%2Ccompress&dpr=1&w=256&h=32)

1. The eigenvalues of the original covariance matrix of an image allow the user to assess whether bands have a high degree of correlation (true or false).

- [x] true
- [ ] false


2. When using principal components for change detection why is it necessary to have a large portion of the scene constant between dates? (Choose the correct answer)

- [ ] the principal components transformation will not work otherwise
- [ ] if that were not the case, then the eigenvalues could not be calculated.
- [x] that causes the change regions to be emphasised in the higher order principal components


3. Is it practically conceivable that we can find an image of the natural landscape for which there is no correlation among bands recorded in the optical wavelengths?

- [x] no, because the bands are samples of the spectral reflectance curves of natural cover types, and those curves are continuous.&nbsp;
- [ ] yes, because the spectral reflectance curves are immaterial to the question
- [ ] no, the sensors are designed to record correlated data
  
4. When using the principal components transformation for data compression in which the later principal components are discarded, is it possible to quantify the information loss? (choose the correct answer)

- [ ] not easily because we have no reliable metrics
- [ ] yes, by looking at the distribution of the components in the first eigenvector
- [x] yes, by looking at the sum of the eigenvalues of the discarded bands compared with the sum of all eigenvalues

5. The first principal component image is sometimes referred to as a “total brightness” image because (choose one answer)

- [x] the elements of the corresponding eigenvector of the image covariance matrix are all positive
- [ ] it uses the full range of brightness values from complete black to complete white
- [ ] it corresponds to the largest eigenvalue of the image covariance matrix

6. Consider an artificial landscape consisting of a black and white chequerboard pattern.&nbsp; Suppose a sensor with blue, green and red sensitive band images that landscape.&nbsp; Which of the following statements is correct?

- [ ] the covariance matrix of the image data will be diagonal
- [x] all the elements of the correlation matrix will be unity
- [ ] one of the eigenvalues of the covariance matrix will be unity and the other two will be zero

7. A sensor with just two bands—red and near IR—images a landscape that is largely bare soil and water, with small amounts of green vegetation.&nbsp; Sketch for yourself a near IR versus red spectral space and show which of the following statements is true concerning the corresponding principal components image.

- [ ] the three cover types will show good separation in the second principal component image
- [ ] because the data is low in correlation the principal components bands will be little different from the original bands
- [x] the first principal component image will show good separation of soil from vegetation and water, whereas the second component will show good separation of vegetation from water and soil

8. Suppose the spectral space for a scene recorded by a sensor with just three bands had all the pixel vectors distributed along a line from the origin to a point corresponding to the maximum brightness in each band.&nbsp; What would the colour composite image product look like?

- [ ] it would display a good range of colour
- [x] it would be a greyscale image
- [ ] it would be mainly shades of grey with a few colours

9. Suppose the spectral space for a scene recorded by a sensor with just three bands had all the pixel vectors distributed around a large sphere in the spectral space.&nbsp; What would the colour composite image product look like?

- [ ] it would display a good range of colour
- [x] it would be a greyscale image
- [ ] it would be mainly shades of grey with a few colours

10.  Why is a colour image formed from the first three principal components usually better for photointerpretation that a colour composite formed from three of the original bands?

- [x] it often highlights in colour regions of interest in a manner not evident in the original colour image
- [ ] image geometry is improved
- [ ] all low interest features are removed with the discarded principal components

