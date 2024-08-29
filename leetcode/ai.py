from IPython.display import Image, display
import matplotlib.pyplot as plt
import matplotlib.image as mpimg
import numpy as np

# Display the image using IPython.display
img_path = 'D:/rafiq/IMG_7540.JPG'
display(Image(filename=img_path))

# Alternatively, display the image using Matplotlib
img = mpimg.imread(img_path)
plt.imshow(img)
plt.axis('off')  # Hide axes

plt.show()
# Rotate the image by 90 degrees
rotated_img = np.rot90(img)

# Display the rotated image
plt.imshow(rotated_img)
plt.axis('off')  # Hide axes

plt.show()