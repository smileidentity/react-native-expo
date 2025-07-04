/**
 * Config class used to pass the smile config to initialize method
 */
export class Config {
  partnerId: string;
  authToken: string;
  prodLambdaUrl: string;
  testLambdaUrl: string;

  constructor(
    partnerId: string,
    authToken: string,
    prodLambdaUrl: string,
    testLambdaUrl: string
  ) {
    this.partnerId = partnerId;
    this.authToken = authToken;
    this.prodLambdaUrl = prodLambdaUrl;
    this.testLambdaUrl = testLambdaUrl;
  }
}

export type SmileIDExpoModuleEvents = {
  onChange: (params: ChangeEventPayload) => void;
};

export type ChangeEventPayload = {
  value: string;
};
