# import the necessary packages
import numpy 

class Perceptron:

  def __init__(self, learning_rate, epochs):
    self.learning_rate = learning_rate
    self.epochs = epochs
    self.weights = None
    self.bias = None

  def fit(self, X, y):
    self.weights = numpy.zeros(X.shape[1])
    self.bias = 0

    for epoch in range(self.epochs):
      for i in range(len(X)):
        x = X[i]
        y_true = y[i]

        prediction = self.predict(x)
        error = y_true - prediction

        self.weights = self.weights + self.learning_rate * (x * error)
        self.bias = self.bias + self.learning_rate * error

  def predict(self, x):
    dot_product = numpy.dot(self.weights, x) + self.bias
    return np.sign(dot_product)
perceptron = Perceptron(0.1, 10)
perceptron.fit([[1, 2], [3, 4], [5, 6]], [0, 1, 0])

print(perceptron.predict([[1, 2], [3, 4], [5, 6]]))