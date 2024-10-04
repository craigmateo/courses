# Week 9 Quiz
![](https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://coursera-course-photos.s3.amazonaws.com/b8/f13d23685c4f8ca8d2a1077826d6b0/Navigation-Thimnail.png?auto=format%2Ccompress&dpr=1&w=256&h=32)

1. The name of the convolutional neural network derives from the fact that the connections between layers are made in localised groups.

- [x] True
- [ ] False

That is correct.  The localised groups form a convolution-like operation

2. The ReLU activation function in a convolutional neural network is used instead of the sigmoid and other functions used in the multi-layer Perceptron because (choose one):

- [ ] It generates more accurate results
- [x] It allows faster convergence during training
- [ ] It improves the multi-class capabilities of the algorithm

That is correct.

3. Accounting for spatial context when classifying an image is important because:

- [ ] Most scenes contain well-defined objects
- [ ] Spatial properties are more important than spectral properties
- [x] Neighbouring pixels are likely to be from the same class.

That is correct.  Most environments exhibit this property (natural, agricultural, urban, water bodies, etc.)

4. What is the reason for including a pooling layer in a convolutional neural network?

- [x] It further reduces the number of connections and helps imbed spatial context
- [ ] Convolutional layers require a pooling layer as their inter-connection
- [ ] It removes the need for an activation function in the preceding convolutional layer

That is correct.

5. The softmax function often used with convolutional neural networks

- [x] Produces a set of probabilities from the outputs
- [ ] Avoids the spread of the output values covering too great a range
- [ ] Makes it easier to see which is the preferred output

That is correct.

6. The stride operation in a convolutional neural network (choose one)

- [ ] Has no effect of the spatial properties being learnt
- [x] Allows the number of connections and thus unknowns to be reduced
- [ ] Must always be smaller than 3

That is correct and is the reason stride is sometimes built into a CNN.

7. Feature (e.g. band) reduction is often applied to hyperspectral imagery before being fed into a convolutional neural network because (choose one)

- [ ] CNNs can’t cope with large data sets
- [ ] We never need to use all the bands anyway
- [x] The number of unknowns found during training is reduced

That is correct.  It simplifies training and can lead to a more accurate classifier—one which generalises well.

8. Compared with a fully connected neural network, convolutional neural nets (choose one):

- [x] Can have more hidden layers because of the fewer connections between nodes
- [ ] Always perform better when spatial context is a consideration
- [ ] Can have fewer output nodes

9. Operating several CNN pathways in parallel is designed to (choose one)

- [ ] Speed up training
- [ ] Speed up the classification step
- [x] Respond to spatial features at dfferent scales

That is correct and is often the reason several parallel paths (filters) is used.

10. Flattening (choose one answer):

- [x] is an operation that turns an array into a column vector
- [ ] Reduces the dynamic range of the values in a measurement vector
- [ ] Is a method for combining two or more arrays

That is correct
