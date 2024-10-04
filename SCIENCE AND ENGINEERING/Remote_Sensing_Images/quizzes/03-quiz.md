## Week 2 Quiz

1. **One of the problems with nearest neighbour resampling is**

it can produce a blocky (pixelated) final product if the output scale is very different from the scale of the recorded image data

2. **When correcting geometric distortions using mapping polynomials a polynomial of high order**

can lead to significant image distortions away from control points

Good matches can be achieved at the control points but the behaviour can be poor in other parts of the image

3. **When registering a set of images together using control points and mapping polynomial the preferred approach is**

to register image 2 to image 1, then image 3 to image 1, the image 4 to image 1, and so on

(registration errors cannot accumulate)

4. **When using a second-degree mapping polynomial the minimum number of control points needed is**

6

5. **When choosing control points they must be**

distributed as evenly as possible over the image

A well-spaced set of control points givens the best registration outcome.

6. **If you suspect the distribution of control point is poor, for whatever reason, it is best to**

use a first degree mapping polynomial

This minimises geometric errors on the average, even though it might not be as good at individual control points as higher degree polynomials.

7. **In general, would you expect a smoother looking geometrically corrected image if you use**

cubic convolution resampling

8. **When recorded, most remote sensing images are poor in contrast because**

the detectors are designed to operate over a range that will detect absolute shadows and maximum brightness, such as clouds and snow

9. **When creating a colour image product from three recorded bands, it is conventional to assign the bands to the display primary colours of blue, green and red**

in increasing order of wavelength

10. **Colour image products are important in photointerpretation because**

a human can generally perceive more detail in colour than in black and white