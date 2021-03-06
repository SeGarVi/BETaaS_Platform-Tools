/**
Copyright 2014-2015 Center for TeleInFrastruktur (CTIF), Aalborg University

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

@author Bayu Anggorojati [ba@es.aau.dk]
Center for TeleInFrastruktur, Aalborg University, Denmark
 */

package eu.betaas.taas.securitymanager.common.ec.operator;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.signers.DSADigestSigner;
import org.bouncycastle.crypto.signers.ECDSASigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.bc.BcContentSignerBuilder;

public class BcECDSAContentSignerBuilder extends BcContentSignerBuilder  {

	public BcECDSAContentSignerBuilder(AlgorithmIdentifier sigAlgId, 
			AlgorithmIdentifier digAlgId) {
		super(sigAlgId, digAlgId);
	}

	@Override
	protected Signer createSigner(AlgorithmIdentifier sigAlgId,
			AlgorithmIdentifier digAlgId) throws OperatorCreationException {
		Digest dig = digestProvider.get(digAlgId);
		return new DSADigestSigner(new ECDSASigner(), dig);
	}


}
