package org.deeplearning4j;

import java.io.File;
import java.io.IOException;
import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.lossfunctions.LossFunctions;


public class LinearClassifier {
    public static void main(String[] args) throws IOException, InterruptedException {
        long seed = 123;
        double learningRate = 0.01;
        int batchSize = 50;
        int epochs = 20;
        int inputs= 2;
        int outputs = 2;
        int hiddenNodes = 20;

        RecordReader rrTrain = new CSVRecordReader();
        rrTrain.initialize(new FileSplit(new File("linear_data_train.csv")));
        DataSetIterator trainIterator = new RecordReaderDataSetIterator(rrTrain, batchSize, 0, 2);

        RecordReader rrTest = new CSVRecordReader();
        rrTest.initialize(new FileSplit(new File("linear_data_eval.csv")));
        DataSetIterator testIterator = new RecordReaderDataSetIterator(rrTest, batchSize, 0, 2);

        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(seed)
                .iterations(1)
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                .learningRate(learningRate)
                .updater(org.deeplearning4j.nn.conf.Updater.NESTEROVS).momentum(0.9)
                .list()
                .layer(0, new DenseLayer.Builder()
                .nIn(inputs)
                .nOut(hiddenNodes)
                .weightInit(WeightInit.XAVIER)
                .activation("relu")
                .build())
                .layer(1, new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                .weightInit(WeightInit.XAVIER)
                .activation("softmax")
                .weightInit(WeightInit.XAVIER)
                .nIn(hiddenNodes)
                .nOut(outputs)
                .build())
                .pretrain(false).backprop(true)
                .build();

                System.out.println(conf.toJson());

                MultiLayerNetwork model = new MultiLayerNetwork(conf);
                model.init();
                model.setListeners(new ScoreIterationListener(10));
                for(int i = 0; i < epochs; i++){
                    model.fit(trainIterator);
                }
                System.out.println("Evaluate model: ");
                Evaluation evaluation = new Evaluation(outputs);
                while(testIterator.hasNext()){
                    DataSet t = testIterator.next();
                    INDArray features = t.getFeatures();
                    INDArray labels =t.getLabels();
                    INDArray predicted = model.output(features, false);

                    evaluation.eval(labels, predicted);
                }
                System.out.println(evaluation.stats());
        }
    }