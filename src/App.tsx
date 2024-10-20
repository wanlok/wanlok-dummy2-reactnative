import React from 'react';
import {Button, NativeModules, SafeAreaView, StyleSheet, useColorScheme, View} from 'react-native';
import {Colors} from 'react-native/Libraries/NewAppScreen';

const styles = StyleSheet.create({
  safeAreaView: {
    flex: 1,
  },
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});

function App() {
  const {CustomShare} = NativeModules;

  return (
    <SafeAreaView
      style={[
        {
          backgroundColor: useColorScheme() === 'dark' ? Colors.darker : Colors.lighter,
        },
        styles.safeAreaView,
      ]}>
      <View style={styles.container}>
        <Button
          title="Hello World"
          onPress={() => {
            CustomShare.open('Nice to meet you 1234', () => {
              console.log('COPY CLICK');
            });
          }}
        />
      </View>
    </SafeAreaView>
  );
}

export default App;
