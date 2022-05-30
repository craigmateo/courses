# Week 10 Quiz
![](https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://coursera-course-photos.s3.amazonaws.com/b8/f13d23685c4f8ca8d2a1077826d6b0/Navigation-Thimnail.png?auto=format%2Ccompress&dpr=1&w=256&h=32)

1. Clustering helps identify which one of the following?

- [x] spectral classes
- [ ] information classes
- [ ] groups of pixels in the spatial domain

That is correct.  The clusters are groups in the data/spectral domain

2. Unsupervised classification is (choose one):

- [ ] Used when a supervised algorithm is unavailable
- [x] Used when sufficient labelled reference data is unavailable with which to train a supervised algorithm
- [ ] Used when we cannot identify the full set of information classes beforehand.

That is correct.

3. In the k means clustering algorithm a good set of starting clusters would be (choose one answer):

- [ ] distributed around the edge of the spectral space
- [x] along the spectral diagonal through the actual data set
- [ ] distributed around a sphere that encloses the data

4. The spectral space in remote sensing naturally clusters into separate groups

- [ ] True?
- [x] False?

5. By initiating the single pass clustering algorithm on the first line of samples (choose one):

- [x] we hope that those samples are sufficiently representative as to be a good place to start
- [ ] we know that the outcome of clustering will not be affected by that choice
- [ ] we ensure the algorithm will converge quickly

That is correct.  It is an assumption that has to be made in order to initialise the algorithm

6. Clustering is a time-consuming operation, particularly on big data sets

- [x] true?
- [ ] False?

That is correct.  The number of (multiplications) operations involved makes it time consuming compared with most supervised classification algorithms.

7. The K trees method for clustering is preferable to the k means approach because (choose one):

- [ ] it finds a better set of clusters
- [ ] it is more accurate
- [x] it is faster to run—i.e. to carry out clustering of a given set of pixels

That is correct, especially for large data sets of high dimensionality

8. The tree order parameter used with K trees clustering (choose one)

- [ ] specifies the number of clusters to be found
- [ ] specifies the number of layers in the tree
- [x] sets an upper limit on the population of each node


9. When used in unsupervised classification the k means algorithm is essentially (choose one):

- [x] a linear classifier
- [ ] a classifier with quadratic decision boundaries
- [ ] neither a linear or a quadratic classifier


10.  A particular K trees exercise generated 36 clusters.&nbsp; It has a maximum population per node of 6 members (clusters or means) and, on completion, all nodes were full.&nbsp; How many distance comparisons are needed to place a previously unseen pixel vector into the most appropriate cluster?

- [ ] 6
- [ ] 7
- [x] 12

That is correct.  Since each node can have six members, there will be a full upper level node with six members (means of the following nodes) and then six leaf nodes each with six members (to give 36 clusters).  A previously unseen pixel enters the top node and is compared with the six means in that node.  That requires six comparisons, as a result of which it is directed to the correct root node.  It is then compared against the six cluster means in that node to find the correct cluster.  Overall, therefore, there have been 12 distance comparisons.
